package com.docmatter.ims.controller;



import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.util.FileUtil;
import com.docmatter.ims.util.ReducerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatController {

    private static final Logger log = LoggerFactory.getLogger(StatController.class);

    @GetMapping("/stat/test")
    public String test() {
        return "/stat/test invoked";
    }


    @GetMapping("/stat/factFileCount")
    public String getFactFileCount() {
        return FileUtil.getFileCountUnderAFolder(ImsConstant.FACT_FILE_OUTPUT_FOLDER);
    }

    @PostMapping(value = "/stat/openEmail/all")
    public String handleDICOMFile(@RequestParam("dates") String[] dates) {
        StringBuilder sb = new StringBuilder();


        sb.append("starting from " + dates[0] + " through " + dates[1] + ", number of email opened by all communities is \n\n");
        Integer beginDate = Integer.valueOf(dates[0]);
        Integer endDate = Integer.valueOf(dates[1]);
        String result = ReducerUtil.runReducer(beginDate, endDate);
        sb.append(result);

        return sb.toString();
    }
}
