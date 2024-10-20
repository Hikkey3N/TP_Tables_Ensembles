package fr.istic.prav.tables;

import java.util.Iterator;

import istic.prg.table_ens.Set;
import istic.prg.table_ens.Table;

public class SocialNetwork extends Table<Integer, Set<Integer>> {
	// constructeur
	public SocialNetwork() {
		super();
	}

	/**
	* @return true si la relation (x,y) appartient à this, false sinon
	*/
	public boolean isDefined(Integer x, Integer y) {
		// Set up the iterator to find the key
		Iterator<Integer> it = this.iterator();

		// Run loop until the key value exceed x (false) or equal to x (can check), else run out of list then return false
		while (it.hasNext()){
			Integer nextValue = it.next();
			if (nextValue> x){
				return false;
			}
			else if (nextValue == x){
				return this.getValue(x).contains(y);
			}
		}
		return false;
	}

	/**
	* @return nombre d’entiers y tels que (x, y) appartient à this.
	*/
	public int numberOfYs(Integer x) {
		// Set up the iterator to find the key
		Iterator<Integer> it = this.iterator();

		int output = 0;

		while (it.hasNext()){
			Integer nextValue = it.next();

			// Surpass x, which means doesn't contain x
			if (nextValue > x){
				return output;
			}
			
			// Meet x, so return the size of the set
			else if (nextValue ==  x){
				output = this.getValue(x).size();
				return output;
			}
		}

		// Run out return 0
		return output;
	}

	/**
	* @return nombre total de doublets (x,y) dans this
	*/
	public int numberOfPairs() {
		int output = 0;

		// Set up the iterator for the key
		Iterator<Integer> it = this.iterator();

		// Number of pairs == number of ys
		while (it.hasNext()){
			output += this.getValue(it.next()).size();
		}

		return output;
	}
	
	/**
	* @return true si this est identique à net, false sinon
	*/
	public boolean equals(SocialNetwork net) {
		// Set up the iterator for the key
		Iterator<Integer> it_this = this.iterator();
		Iterator<Integer> it_net = net.iterator();

		while (it_this.hasNext() && it_net.hasNext()) {
			Set<Integer> set_this = this.getValue(it_this.next());
			Set<Integer> set_net = net.getValue(it_net.next());

			// if any set is not equal, return false
			if (!set_this.equals(set_net)){
				return false;
			}
		}

		// Check if 2 objects are equal in size or not, if equal in size then true, false if not
		if (it_this.hasNext() || it_net.hasNext()){
			return false;
		}
		else{
			return true;
		}
	}

	/**
	* Ajouter la relation (x,y) à this (sans effet si (x, y) est
	* déjà présent)
	*/
	public void addRelation(Integer x, Integer y) {
		// If this. already doesn't contain (x, y) then the function will run 
		if (!this.isDefined(x, y)) {
			// Make a clone of this
			Table<Integer, Set<Integer>> copyThis = this.copyOf();

			// Set up the iterators for the copy
			Iterator<Integer> it_copy = copyThis.iterator();

			while (it_copy.hasNext()){
				// If surpass x, create a newSet that contains y and add into this (x, newSet)
				if (it_copy.next() > x) {
					Set<Integer> newSet = new Set<Integer>();
					newSet.add(y);
					this.addValue(x, newSet);
				}

				// If equal x, create a cloneSet that attached to x, add y into cloneSet and then modify(x, cloneSet)
				else if (it_copy.next() == x) {
					Set<Integer> cloneSet = this.getValue(x).copyOf();
					cloneSet.add(y);
					this.modifyValue(x, cloneSet);
				}

				it_copy.next();
			}

			Set<Integer> newSet = new Set<Integer>();
			newSet.add(y);
			this.addValue(x, newSet);
		}
	}

	/**
	* Supprimer la relation (x,y) de this (sans effet si (x, y) n’est
	* pas présent).
	*/
	public void removeRelation(Integer x, Integer y) {
		// If this contains (x, y) then the function will run
		if (this.isDefined(x, y)) {
			// Make a clone of this
			Table<Integer, Set<Integer>> copyThis = this.copyOf();

			// Set up the iterators for the copy
			Iterator<Integer> it_copy = copyThis.iterator();

			while (it_copy.hasNext()) {
				if (it_copy.next() == x) {
					Set<Integer> cloneSet = this.getValue(x).copyOf();
					cloneSet.remove(y);

					// After removing y, if the set is empty, eliminate the whole element. If not then modify new set to x
					if (cloneSet.size() == 0) {
						this.removeValue(x);
					}
					else {
						this.modifyValue(x, cloneSet);
					}
				}
			}
		}
		
	}

	/**
	* @return nombre de triplets (x, y, z) tels que (x,y) appartient
	* à this et (y,z) appartient à net
	*/
	public int join(SocialNetwork net) {
		// TODO: écrire join(net)
		return -1;

	}

	/**
	* @return relation symétrique de this, la relation constituée des
	* (y, x) tels que (x, y) appartient à this.
	*/
	public SocialNetwork symmetricRelation() {
		// TODO: écrire symetricRelation()
		SocialNetwork res = new SocialNetwork();
		return res;
	}

	/**
	* @return true si this est une relation réflexive (i.e. si pour
	* toute entrée x de this, (x, x) appartient à this), false sinon
	*/
	public boolean isReflexive() {
		// TODO: écrire isReflexive()
		return false;
	}

	/**
	* @return true si this est inclus dans net, false sinon
	*/
	public boolean isIncludedIn(SocialNetwork net) {
		// TODO: écrire isIncludedIn(net)
		return false;
	}

	/**
	* @return intersection de this et net
	*/
	public SocialNetwork intersection(SocialNetwork net) {
		SocialNetwork res = new SocialNetwork();
		// TODO: écrire intersection(net)
		return res;
	}

	/**
	* this devient l’intersection de this et net.
	*/
	public void intersectionBis(SocialNetwork net) {
		// TODO: écrire intersectionBis(net)
	}

	/**
	* this devient l’union de this et net.
	*/
	public void union(SocialNetwork net) {
		// TODO: écrire union(net)
	}
}

