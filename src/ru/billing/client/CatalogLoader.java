package ru.billing.client;

import ru.billing.stocklist.*;
import ru.exception.CatalogLoadException;
import ru.exception.ItemAlreadyExistsException;

public interface CatalogLoader {
    public void load(ItemCatalog cat) throws CatalogLoadException, ItemAlreadyExistsException;
}
