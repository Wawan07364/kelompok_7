


package Model;
import java.sql.Connection;
import Helper.KoneksiDb;

public abstract class ModelAbstract {
    Connection conn = KoneksiDb.getconection();
    
    public abstract void UpdatePassword(String password, int Nik);
    public abstract int cekLogin(String nama, String password);
    
}
