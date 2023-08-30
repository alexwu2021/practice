
echo 'starting all the cleanup jobs ...'

# clean up all the fact files
rm -f ../../src/main/resources/mapred/output/fact_files/*.fac




# clean up all the exf files
rm -f ../../src/main/resources/mapred/output/exploded_fact_files/*.exf


# clean up all the reference files
rm -f ../../src/main/resources/mapred/reference_data/computed/*.ref


# clean up all the mpi files
rm -f ../../src/main/resources/mapred/input/*.mpi
rm -f ../../src/main/resources/mapred/reference_data/base/*.mpi

echo 'done all the cleanup jobs'



