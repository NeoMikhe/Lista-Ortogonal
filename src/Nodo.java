public class Nodo {

	private Nodo sig; //siguiente
	private Nodo ant; //anterior
	private Nodo ab; //abajo
	private Nodo arr; //arriba
	private int dato;
	
	public Nodo() {
		dato = 0;
		sig = null;
		ab = null;
		ant = null;
		arr = null;
	}
	
	public Nodo(int dato) {
		this.dato = dato;
		sig = null;
		ab = null;
		ant = null;
		arr = null;
	}

	public Nodo getSig() {
		return sig;
	}

	public void setSig(Nodo sig) {
		this.sig = sig;
	}

	public Nodo getAnt() {
		return ant;
	}

	public void setAnt(Nodo ant) {
		this.ant = ant;
	}

	public Nodo getAb() {
		return ab;
	}

	public void setAb(Nodo ab) {
		this.ab = ab;
	}

	public Nodo getArr() {
		return arr;
	}

	public void setArr(Nodo arr) {
		this.arr = arr;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

}
