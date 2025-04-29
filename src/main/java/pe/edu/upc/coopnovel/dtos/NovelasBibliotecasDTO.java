package pe.edu.upc.coopnovel.dtos;

import jakarta.persistence.Column;

public class NovelasBibliotecasDTO {
    private int idNovelaBibioetca;
    private int NOVELASidBibioteca;
    private int BIBIOTECAidBibioteca;

    public int getIdNovelaBibioetca() {
        return idNovelaBibioetca;
    }

    public void setIdNovelaBibioetca(int idNovelaBibioetca) {
        this.idNovelaBibioetca = idNovelaBibioetca;
    }

    public int getNOVELASidBibioteca() {
        return NOVELASidBibioteca;
    }

    public void setNOVELASidBibioteca(int NOVELASidBibioteca) {
        this.NOVELASidBibioteca = NOVELASidBibioteca;
    }

    public int getBIBIOTECAidBibioteca() {
        return BIBIOTECAidBibioteca;
    }

    public void setBIBIOTECAidBibioteca(int BIBIOTECAidBibioteca) {
        this.BIBIOTECAidBibioteca = BIBIOTECAidBibioteca;
    }
}
