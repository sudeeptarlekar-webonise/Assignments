#!bin/bash/

(
	echo ""
	echo "----------------------------------------"
	echo "Log generated on"
	date
	echo ""
	echo "Creating directory"
	mkdir public_html
	echo "Directory created"
	cd public_html
	echo "creating txt file"
	touch readme.txt
	echo "--------------------------------------------"
	echo ""
) | tee -a Assignment1.log
