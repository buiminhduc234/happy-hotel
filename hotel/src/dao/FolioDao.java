package dao;

import model.Folio;

public interface FolioDao {
    public void insert(Folio folio);
    public Folio findById(int id);
}
