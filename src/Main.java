import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        ListaOrtogonal miLista = new ListaOrtogonal();

        int menu = -1;
        int n, m;
        int pos = 0;
		Scanner t = new Scanner(System.in);

		System.out.println("Creacion de la lista");

        System.out.print("Ingresar renglones: ");
		n = t.nextInt();
		System.out.print("Ingresar columnas: ");
		m = t.nextInt();
        miLista.crearLista(n, m);

		while(menu != 0) {

			//Menu
			menu = Integer.parseInt(JOptionPane.showInputDialog(null,"< - > Menu Lista Ortogonal < - >\n"
					+ "1.- Recorrer Lista e imprimir\n"
					+ "2.- Imprimir el tamano de la lista\n"
					+ "3.- Numero de renglones\n"
					+ "4.- Numero de columnas\n"
					+ "5.- Insertar columna en cualquier posicion\n"
					+ "6.- Insertar renglon en cualquier posicion\n"
                    + "7.- Eliminar columna en cualquier posicion\n"
                    + "8.- Eliminar renglon en cualquier posicion\n"
					+ "0.- Salir\n"
					+ "< - > Menu Lista Ortogonal < - >", "Ingresa una opcion"));

			switch(menu) {
            
            case 0:
                System.out.println("Decidiste salir del programa, adios!");
				break;

			case 1:
				System.out.println("Metodo recorrer e imprimir valores de la lista.");
                miLista.recorrer();
				break;

			case 2:
				System.out.println("Metodo obtener el tamano de la lista.");
                if(miLista.tamano() != 0)
                    System.out.println("El tamano de la lista es: "+miLista.tamano());
				break;

			case 3:
				System.out.println("Metodo obtener el numero de renglones");
                System.out.println("Numero de renglones: "+miLista.numRenglones());
				break;

			case 4:
				System.out.println("Metodo obtener el numero de columnas");
                System.out.println("Numero de columnas: "+miLista.numColumnas());
				break;

			case 5:
				System.out.println("Metodo ingresar columna en posicion");
                System.out.print("Ingresa la posicion a insertar columna: ");
                pos = t.nextInt();
                miLista.insertarColumna(pos, m);
				break;

			case 6:
				System.out.println("Metodo ingresar renglon en posicion");
                System.out.print("Ingresa la posicion a insertar renglon: ");
                pos = t.nextInt();
                miLista.insertarRenglon(pos, n);
				break;
            
            case 7:
				System.out.println("Metodo borrar columna");
                System.out.print("Ingresa la posicion a eliminar columna: ");
                pos = t.nextInt();
                miLista.eliminarColumna(pos, m);
				break;

            case 8:
				System.out.println("Metodo borrar renglon");
                System.out.print("Ingresa la posicion a eliminar renglon: ");
                pos = t.nextInt();
                miLista.eliminarRenglon(pos, n);
				break;

			default:
                System.out.println("Ingresaste una opcion no disponible del menu");
				break;		
			}
		}

    }
}
