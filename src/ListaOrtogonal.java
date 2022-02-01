import java.util.Scanner;

public class ListaOrtogonal {

	Nodo head;
	Scanner teclado = new Scanner(System.in);

	public ListaOrtogonal() {
		head = null;
	}
	
	public void crearLista(int n, int m) {
		Nodo q = new Nodo();
		Nodo r = new Nodo();
		int num = 0;

		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				Nodo p = new Nodo();
				System.out.print("Ingresa dato: ");
				num = teclado.nextInt();
				p.setDato(num);
				p.setSig(null);
				p.setAb(null);

				if(j == 1){
					p.setAnt(null);
					if(head == null)
						head = p;
					q = p;
				}else {
					p.setAnt(q);
					q.setSig(p);
					q = p;
				}

				if(i == 1){
					p.setArr(null);
					q = p;
				}else {
					p.setArr(r);
					r.setAb(p);
					r = r.getSig();
				}
			}
			r = head;
			while (r.getAb() != null)
				r = r.getAb();
		}
	}
	
	public void recorrer() {
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		int cont = 1, cont2 = 1;
		if(head != null){
			p = head;
			while(p != null){
				q = p;
				System.out.println("Renglon no.: "+cont);
				while(q != null){
					System.out.println("Columna no.: "+cont2+" Dato del nodo: "+q.getDato());
					q = q.getSig();
					cont2++;
				}
				p = p.getAb();
				cont++;
				cont2 = 1;
			}
		}else 
			System.out.println("Lista vacia...");
	}
	
	public int tamano() {
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		int n = 0;
		
		if(head != null) {
			p = head;
			while(p != null) {
				q = p;
				while(q != null) {
					n++;
					q = q.getSig();
				}
				p = p.getAb();
			}
		}else
			System.out.println("Lista vacia...");
		return n;
	}
	
	public int numRenglones() {
		Nodo p = new Nodo();
		int n = 0;
		
		if(head != null) {
			p = head;
			while(p != null) {
				n++;
				p = p.getAb();
			}
		}else
			System.out.println("Lista vacia...");

		return n;		
	}
	
	public int numColumnas() {
		Nodo p = new Nodo();
		int n = 0;
		
		if(head != null) {
			p = head;
			while(p != null) {
				n++;
				p = p.getSig();
			}
		}else
			System.out.println("Lista vacia...");

		return n;		
	}
	
	public void insertarColumna(int pos, int col) {
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		int n = 0, num = 0;

		p = head;
		if(pos <= col+1) {
			if(pos == 1) {
				if(head != null) {
					q = p;
					while(q != null) {
						Nodo r = new Nodo();
						System.out.print("Ingresa dato: ");
						num = teclado.nextInt();
						r.setDato(num);
						r.setSig(q);
						r.getSig().setAnt(r);
						if(q.getArr() == null)
							head = r;
						else {
							r.setArr(q.getArr().getSig());
							r.getArr().setAb(r);
						}
						q = q.getAb();
					}
				}else {
					Nodo r = new Nodo();
					num = teclado.nextInt();
					r.setDato(num);
					head = r;
				}
			}else {
				n = 1;
				while(n < pos-1) {
					n++;
					p = p.getSig();
				}
				q = p;
				while(q != null) {
					Nodo r = new Nodo();
					System.out.print("Ingresa dato: ");
					num = teclado.nextInt();
					r.setDato(num);
					r.setAnt(q);
					r.setSig(q.getSig());
					r.getAnt().setSig(r);
					if(r.getSig() != null)
						r.getSig().setAnt(r);
					if(q.getArr() != null){
						r.setArr(q.getArr().getSig());
						r.getArr().setAb(r);
					}
					q = q.getAb();
				}
			}
		}else
			System.out.println("Posicion invalida");
	}
	
	public void insertarRenglon(int pos, int ren) {
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		int n = 0, num = 0;

		p = head;
		if(pos <= ren+1) {
			if(pos == 1) {
				q = p;
				while(q != null) {
					Nodo r = new Nodo();
					System.out.print("Ingresa dato: ");
					num = teclado.nextInt();
					r.setDato(num);
					r.setAb(q);
					r.getAb().setArr(r);
					if(q.getAnt() == null)
							head = r;
					else {
						r.setAnt(q.getAnt().getArr());
						r.getAnt().setSig(r);
					}
					q = q.getSig();
				}
			}else {
				n = 1;
				while(n < pos-1) {
					n++;
					p = p.getAb();
				}
				q = p;
				while(q != null) {
					Nodo r = new Nodo();
					System.out.print("Ingresa dato: ");
					num = teclado.nextInt();
					r.setDato(num);
					r.setArr(q);
					r.setAb(q.getAb());
					r.getArr().setAb(r);
					if(r.getAb() != null)
						r.getAb().setArr(r);
					if(q.getAnt() != null){
						r.setAnt(q.getAnt().getAb());
						r.getAnt().setSig(r);
					}
					q = q.getSig();
				}
			}
		}else
			System.out.println("Posicion invalida");
	}
	
	public void eliminarColumna(int pos, int col) {
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		int n = 0;

		if(head != null) {
			p = head;
			if(pos <= col) {
				if(pos == 1) {
					q = head.getSig();
					if(q != null) {
						while(q != null) {
							q.setAnt(null);
							if(p == head)
								head = q;
							q = q.getAb();
							if(q != null)
								p = q.getAnt();
						}
					}else {
						while(p != null) {
							head = head.getAb();
							p = head;
						}
					}
				}else {
					n = 1;
					while(n < pos-1) {
						n++;
						p = p.getSig();
					}
					q = p.getSig();
					while(p != null) {
						p.setSig(q.getSig());
						if(p.getSig() != null)
							p.getSig().setAnt(p);
						p = p.getAb();
						if(p != null)
							q = p.getSig();
					}
				}
			}else
				System.out.println("Posicion invalida");
		}else
			System.out.println("Lista vacia...");
	}
	
	public void eliminarRenglon(int pos, int ren) {
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		int n = 0;

		if(head != null) {
			p = head;
			if(pos <= ren) {
				if(pos == 1) {
					q = head.getAb();
					if(q != null) {
						while(q != null) {
							q.setArr(null);
							if(p == head)
								head = q;
							q = q.getSig();
							if(q != null)
								p = q.getArr();
						}
					}else {
						while(p != null) {
							head = head.getSig();
							p = head;
						}
					}
				}else {
					n = 1;
					while(n < pos-1) {
						n++;
						p = p.getAb();
					}
					q = p.getAb();
					while(p != null) {
						p.setAb(q.getAb());
						if(p.getAb() != null)
							p.getAb().setArr(p);
						p = p.getSig();
						if(p != null)
							q = p.getAb();
					}
				}
			}else
				System.out.println("Posicion invalida");
		}else
			System.out.println("Lista vacia...");
	}
}
