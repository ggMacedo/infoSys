
package DAO;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */

import java.util.List;

public interface Persistencia<T> {
    public int create (T obj);
    public List<T> read();
    public boolean update(T obj);
    public boolean delete(T obj);
    public T findByCodigo(int id);
    
    
}
