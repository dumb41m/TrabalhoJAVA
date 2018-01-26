/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Model.Entity.Aluno;

/**
 *
 * @author JVM
 */
public class TableModelAluno extends AbstractTableModel{
    
    private List<Aluno> listaAlunos = new ArrayList<Aluno>();
    private final String[] colunas = {"Nome", "Sexo", "Data Nascimento", "Matricula", "Curso", "Email"};

    
    /**
     * Retorna uma linha completa da tabela
     * @param rowIndex
     * @return Aluno
     */
    public Aluno getAluno(int rowIndex){
        return this.listaAlunos.get(rowIndex);
    }
    
    /**
     * Adiciona uma jogador a tabela (cria uma linha)
     * @param aluno 
     */
    public void addAluno(Aluno aluno){
        this.listaAlunos.add(aluno);
        fireTableDataChanged();
    }
    
    /**
     * Adiciona uma jogador a tabela (cria uma linha)
     * @param aluno 
     */
    public void addTodosAlunos(List<Aluno> listaAlunos){
        this.listaAlunos.addAll(listaAlunos);
        fireTableDataChanged();
    }
    
    /**
     * Remove uma jogador da tabela (remove uma linha)
     * @param rowIndex 
     */
    public void removeAluno(int rowIndex){
        this.listaAlunos.remove(rowIndex);
        fireTableDataChanged();
    }
    
    
    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaAlunos.size();
    }

    /**
     * Retorna o numero de colunas da tabela
     *
     * @return int
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Retorna o valor especifico de uma celula
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        //switch na coluna
        switch (columnIndex) {

            //coluna do nome do jogador
            case 0:
                return this.listaAlunos.get(rowIndex).getId();
            //coluna do email
            case 1:
                return this.listaAlunos.get(rowIndex).getNome();
            case 2:
                return this.listaAlunos.get(rowIndex).getSexo();
            case 3:
                return this.listaAlunos.get(rowIndex).getdNasc();
            case 4:
                return this.listaAlunos.get(rowIndex).getMatricula();
            case 5:
                return this.listaAlunos.get(rowIndex).getCurso();
            case 6:
                return this.listaAlunos.get(rowIndex).getEmail();

            default:
                return this.listaAlunos.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
    
    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunoes(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public void limpar() {
        this.listaAlunos = new ArrayList<Aluno>();
        fireTableDataChanged();
    }
 
}
