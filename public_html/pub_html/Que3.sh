#!bin/bash/

(
	echo ""
	echo "-------------------------------------------"
	echo "Log generated on"
	date
	echo ""
	rename -v 's//xx/' x*
	echo "--------------------------------------------"
	echo ""
) | tee -a Assignment1.log

