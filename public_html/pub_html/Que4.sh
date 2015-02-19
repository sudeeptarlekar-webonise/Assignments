#!bin/bash/

(
	rename -n 's/\.txt$/_\.txt/' *.txt
	rename -n 's//xx/' x*
) | tee -a Assignment1.log
