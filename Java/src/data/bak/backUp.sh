# copy files from src/main/resources/mapred/input

rm -rf ./*.mpi
echo "copy files from src/main/resources/mapred/input"
cp -f ../../src/main/resources/mapred/input/ctxMessage.mpi .
cp -f ../../src/main/resources/mapred/input/emailOpenUdt.mpi .
cp -f ../../src/main/resources/mapred/input/notificationCtxMessage.mpi .
cp -f ../../src/main/resources/mapred/input/postComm.mpi .
cp -f ../../src/main/resources/mapred/input/logNotificationEmailView.mpi .


# copy files from src/main/resources/mapred/reference_data/base
echo "copy files from src/main/resources/mapred/reference_data/base"
cp -f ../../src/main/resources/mapred/reference_data/base/community.mpi .
cp -f ../../src/main/resources/mapred/reference_data/base/ctxEntity.mpi .
cp -f ../../src/main/resources/mapred/reference_data/base/ctxEntityRel.mpi .
cp -f ../../src/main/resources/mapred/reference_data/base/productGroup.mpi .
cp -f ../../src/main/resources/mapred/reference_data/base/userCommunity.mpi .
cp -f ../../src/main/resources/mapred/reference_data/base/userProductGroup.mpi .

ls -la