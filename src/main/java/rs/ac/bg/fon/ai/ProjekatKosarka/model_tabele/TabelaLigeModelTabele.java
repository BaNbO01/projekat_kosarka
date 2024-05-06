/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.model_tabele;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;

/**
 *
 * @author Korisnik
 */

@Component
public class TabelaLigeModelTabele extends AbstractTableModel {

    List<Tabela> listaTabela;
    String[] kolone = {"Tim", "brojPobeda", "brojPoraza", "kosRazlika", "liga"};

    public List<Tabela> getListaTabela() {
        return listaTabela;
    }

    public void setListaTabela(List<Tabela> listaTabela) {
        this.listaTabela = listaTabela;
    }

    
    
    @Autowired
    public TabelaLigeModelTabele(List<Tabela> listaTabela) {
        this.listaTabela = listaTabela;
        listaTabela.clear();
    }

    @Override
    public int getRowCount() {
        return listaTabela.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tabela t = listaTabela.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getTimid().getNaziv();

            case 1:
                return t.getBrojPobeda();

            case 2:
                return t.getBrojPoraza();
            case 3:
                return t.getKosRazlika();

            case 4:
                return t.getLiga().getNaziv();
            default:
                throw new RuntimeException("Ne postoji takva kolona");
        }
    }

    @Override
    public String getColumnName(int column) {
    return kolone[column];
    }
    
    

}
