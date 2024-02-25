/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la interface IDAO
*/
package DataAccess;

import java.util.List;

public interface IDAO<T> {
    public boolean create(T entity) throws Exception;
    public List<T> readAll() throws Exception;
    public T readBy(Integer id) throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(Integer id) throws Exception;
    public boolean restore(Integer id) throws Exception;
}