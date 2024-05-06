/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.model_tabele;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;

/**
 *
 * @author Korisnik
 */

@Component
public class TabelaIgraciModelTabele extends AbstractTableModel {
    

    private List<Igraci> lista;

    @Autowired
    public TabelaIgraciModelTabele(List<Igraci> lista) {
        this.lista = lista;
        this.lista.clear();
    }

   
    
    String[] kolone = {"Ime", "Prezime", "broj", "godiste", "visina","pozicija","tim","nacionalnost"};

    public List<Igraci> getListaIgraci() {
        return lista;
    }
    public void setListaIgraci(List<Igraci> igraciLista) {
        this.lista = igraciLista;
    }

    
    
    
   

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Igraci i = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getIme();

            case 1:
                return i.getPrezime();

            case 2:
                return i.getBroj();
            case 3:
            {
                if(i.getDatumRodjenja()==null)
                    return null;
                LocalDate ld = i.getDatumRodjenja().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return String.valueOf(ld.getYear());
            }

            case 4:
                return i.getVisina();
                
                 case 5:
                return i.getPozicija();
                 case 6:
                return i.getTimId().getNaziv();
                 case 7:
                return i.getDrzavaId().getNaziv();
                
            default:
                throw new RuntimeException("Ne postoji takva kolona");
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
}
