package arreglos;

import clases.Consumo;

import java.io.*;
import java.util.ArrayList;

public class ArregloConsumo {

	// Atributo privado
    private ArrayList<Consumo> consumos;

    // Constructor
    public ArregloConsumo() {
        consumos = new ArrayList<Consumo>();
        cargarConsumo();
    }

    // Operaciones públicas básicas
    public void adicionar(Consumo x) {
        consumos.add(x);
        grabarConsumo();
    }

    public int tamaño() {
        return consumos.size();
    }

    public Consumo obtener(int i) {
        return consumos.get(i);
    }

    public Consumo buscar(int codigoConsumo) {
        for (int i = 0; i < tamaño(); i++)
            if (obtener(i).getcodigoConsumo()==codigoConsumo)
                return obtener(i);
        return null;
    }

    public void eliminar(Consumo x) {
        consumos.remove(x);
        grabarConsumo();
    }

    public void actualizarArchivo() {
        grabarConsumo();
    }

    private void grabarConsumo() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Consumo.txt"));
            for (int i = 0; i < tamaño(); i++) {
                Consumo x = obtener(i);
                String linea = x.getcodigoConsumo() + ";" +
                        x.getCliente() + ";" +
                        x.getFechaConsumo() + ";" +
                        x.getImporteTotal();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarConsumo() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Consumo.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] s = linea.split(";");
                int codigoConsumo = Integer.parseInt(s[0].trim());
                int Cliente = Integer.parseInt(s[1].trim());
                String FechaConsumo= s[2].trim();
                double ImporteTotal = Double.parseDouble(s[3].trim());
         

                adicionar(new Consumo(Cliente, codigoConsumo,FechaConsumo, ImporteTotal));
            }
            br.close();
        } catch (Exception e) {
           
        }
    }

    // Operaciones públicas complementarias
    public String codigoCorrelativo() {
        if (tamaño() == 0)
            return "CON00" + 1;
        else{
        	int cod = obtener(tamaño() - 1).getcodigoConsumo() + 1;
            if (cod%10<0)
            	return "CON00"+ cod;
            else
            	return "CON0" + cod;
            
        }
    }
}