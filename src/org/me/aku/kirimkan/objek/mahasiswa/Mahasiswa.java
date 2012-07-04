
package org.me.aku.kirimkan.objek.mahasiswa;

import java.io.Serializable;


public class Mahasiswa implements Serializable
{
    private String nim;
    private String nama;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public String toString() {
        return " nim= " + nim + ", nama=" + nama;
    }
    
    
}
