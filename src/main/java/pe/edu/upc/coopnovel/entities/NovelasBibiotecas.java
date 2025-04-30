package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

@Entity
@Table(name="NovelasBibiotecas")
public class NovelasBibiotecas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNovelaBibioetca;

    @Column(name="NOVELASidBibioteca")
    private int NOVELASidBibioteca;

    @Column(name="BIBIOTECAidBibioteca")
    private int BIBIOTECAidBibioteca;

    public NovelasBibiotecas() {

    }

    public NovelasBibiotecas(int idNovelaBibioetca, int NOVELASidBibioteca, int BIBIOTECAidBibioteca) {
        this.idNovelaBibioetca = idNovelaBibioetca;
        this.NOVELASidBibioteca = NOVELASidBibioteca;
        this.BIBIOTECAidBibioteca = BIBIOTECAidBibioteca;
    }

    public void update(NovelasBibiotecas nb) {
    }

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
