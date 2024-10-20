package fr.istic.prav.tables.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.istic.prav.tables.SocialNetwork;
import istic.prg.table_ens.Set;

public class TestSocialNetwork {
	public SocialNetwork initExemple() {
		// retourne la table SocialNetwork correspondant à l'exemple du TD
		SocialNetwork exGraphe = new SocialNetwork();
		Set<Integer> successeurs1= new Set<Integer>();
		successeurs1.add(2); successeurs1.add(3); successeurs1.add(5);
		exGraphe.addValue(1, successeurs1);
		Set<Integer> successeurs3= new Set<Integer>(); successeurs3.add(6); 
		exGraphe.addValue(3, successeurs3);
		Set<Integer> successeurs5= new Set<Integer>(); successeurs5.add(5);  successeurs5.add(7); 
		exGraphe.addValue(5, successeurs5);
		Set<Integer> successeurs6= new Set<Integer>(); successeurs6.add(2); successeurs6.add(5);  successeurs6.add(7); 
		exGraphe.addValue(6, successeurs6);
		Set<Integer> successeurs7= new Set<Integer>(); successeurs7.add(6);
		exGraphe.addValue(7, successeurs7);
		System.out.println(exGraphe);
		return exGraphe;
	}
	
	
	@Test
	public void testIsDefined1() {
		SocialNetwork net = initExemple();
		boolean resulV = net.isDefined(1,2);
		boolean resulF = net.isDefined(2,1);
		assertTrue(resulV);
		assertFalse(resulF);
	
	}
	@Test
	public void testNumberbOfYs1() {
		SocialNetwork net = initExemple();
		int resul = net.numberOfYs(1);
		assertEquals(resul,3);
	}
	@Test
	public void testEquals1() {
		SocialNetwork net1 = initExemple();
		SocialNetwork net2 = initExemple();
		boolean resul = net1.equals(net2);
		assertTrue(resul);
	}
	@Test
	public void testEquals2() {
		SocialNetwork net1 = initExemple();
		SocialNetwork net2 = initExemple();
		Set successeurs2 = new Set<Integer>();
		successeurs2.add(3);
		net2.addValue(2,successeurs2);
		boolean resul = net1.equals(net2);
		assertFalse(resul);
	}
	@Test
	public void testEquals3() {
		SocialNetwork net1 = initExemple();
		SocialNetwork net2 = initExemple();
		Set successeurs2 = new Set<Integer>();
		successeurs2.add(3);
		net2.addValue(2,successeurs2);
		net2.removeValue(7);
		System.out.println(net2);
		boolean resul = net1.equals(net2);
		assertFalse(resul);
	}
}
