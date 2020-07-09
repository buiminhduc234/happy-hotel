package controller;

import dao.FolioDao;
import dao.FolioDaoImpl;
import javafx.event.ActionEvent;
import model.Folio;

public class AddNewFolioController {
    public AddNewFolioController() {}
    public void insert(String name, int id) {
        if (!validate(name, id)) {
            return;
        }
        FolioDao dao = new FolioDaoImpl();
        Folio folio = new Folio();
        folio.setId(id);
        folio.setName(name);
        dao.insert(folio);
    }

    private boolean validate(String name, int id) {
        return true;
    }

    public void insertFolio(ActionEvent actionEvent) {
        insert("nhan", 28);
    }
}
