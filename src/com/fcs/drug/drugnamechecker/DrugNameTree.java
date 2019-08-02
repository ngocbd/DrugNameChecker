package com.fcs.drug.drugnamechecker;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.logging.Logger;


public class DrugNameTree {

	private static Logger log = Logger.getLogger(DrugNameTree.class.getName());

	public static Node createTree(TST tst) {
		long startTime = System.currentTimeMillis();

		try {
			InputStream inputStream = getWordListFile();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			String token[] = null;
			while ((line = br.readLine()) != null) {
				
				tst.insert(line, "1");
			}

			inputStream.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("DrugNameTree creadted in : " + ((System.currentTimeMillis() - startTime)) + " ms");
		return tst.getRoot();
	}

	private static InputStream getWordListFile() throws URISyntaxException {
		return DrugNameTree.class.getResourceAsStream("drugname.tsv");
	}
}