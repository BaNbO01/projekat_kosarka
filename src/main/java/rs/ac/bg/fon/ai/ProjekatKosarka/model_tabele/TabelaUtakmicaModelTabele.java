/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.model_tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;

/**
 *
 * @author Korisnik
 */
@Component
public class TabelaUtakmicaModelTabele extends AbstractTableModel{

    String[] columns = {"Domacin","Broj koseva domacina","Broj kosa gost","Gost","Grad domacin"};
    
    private List<Utakmica> listaUtakmica;


    public void setListaUtakmica(List<Utakmica> listaUtakmica) {
        this.listaUtakmica = listaUtakmica;
        
    }
    
    @Autowired
    public TabelaUtakmicaModelTabele(List<Utakmica> listaUtakmica){
        this.listaUtakmica = listaUtakmica;
        listaUtakmica.clear();
    }
    @Override
    public int getRowCount() {
        return listaUtakmica.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Utakmica utakmica = listaUtakmica.get(rowIndex);
        switch(columnIndex){
            case 0:return utakmica.getTimid1().getNaziv();
            case 1:return String.valueOf(utakmica.getBrojKosevaTima1());
            case 2:return String.valueOf(utakmica.getBrojKosevaTima2());
            case 3:return utakmica.getTimid2().getNaziv();
            case 4:return utakmica.getTimid1().getGrad();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    
}
