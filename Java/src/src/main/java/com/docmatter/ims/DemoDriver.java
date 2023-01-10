package com.docmatter.ims;

import com.docmatter.ims.cache.ReferenceDataManager;
import com.docmatter.ims.kafka.KafkaSim;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DemoDriver extends TimerTask {

    private static final int NUMBER_OF_MS_FOR_NEXT_FULL_RUN = 10 * 1000;

    public DemoDriver() throws FileNotFoundException {
        Timer timer = new Timer();
        int period = NUMBER_OF_MS_FOR_NEXT_FULL_RUN;
        period = Integer.MAX_VALUE;
        timer.scheduleAtFixedRate(this, new Date(), period);

        System.out.println("simulating handling of streaming event data");
        KafkaSim kafkaSim1 = new KafkaSim(1);
        new Thread(kafkaSim1).start();

        KafkaSim kafkaSim2 = new KafkaSim(2);
        new Thread(kafkaSim2).start();
    }

    public void run() {
        System.out.println("\n\n[=============================timer task triggered");
        // build the user collection, nug to nug mapping, and user to nug list mapping
        // on the basis of the following files: community.mpi, ctxEntity.mpi, ctxEntityRel.mpi, and productGroup.mpi
        try {
            ReferenceDataManager.me().processBaseReferenceDataFiles();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // process db data, mainly referring to these files: ctxMessage.mpi and postComm.mpi
        try {
            BulkDataProcessor.me().processBulkData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("=================================timer task done]\n\n");
    }

}



