package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Drug;

import java.util.ArrayList;

/**
 * Hospindex with demo data.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
public class HospIndex {
	public static ArrayList<Drug> druglist = new ArrayList<Drug>();

	/**
	 * generate Hospindex with demodata.
	 */
	public HospIndex() {
		druglist.add(new Drug("Ibuprofen 400mg", "IBUPROFEN AL akut 400mg Film-coated-tablet", "400mg",
				"Film-coated-tablet", "Pcs", "Take with a glas of water", "Pain"));
		druglist.add(new Drug("Ibuprofen 200mg", "IBUPROFEN AL akut 200mg Film-coated-tablet", "200mg",
				"Film-coated-tablet", "Pcs", "Take with a glas of water", "Pain"));
		druglist.add(new Drug("Ibuprofen 600mg", "IBUPROFEN AL akut 600mg Film-coated-tablet", "600mg",
				"Film-coated-tablet", "Pcs", "Take with a glas of water", "Pain"));
	}

	/**
	 * Return drug list.
	 * 
	 * @return Hospindex.
	 */
	public ArrayList<Drug> getDrugList() {
		return druglist;
	}
}
