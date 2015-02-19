#!bin/bash
(
	echo "----------------------------------------------"
	echo "log generated on"
	date
	echo ""
	echo "Renaming files starting with extension .txt"
	echo ""
	rename -v 's/\.txt$/_\.txt/' *.txt
	echo "----------------------------------------------"
	echo ""
) | tee -a Assignment1.log
