package com.arobs.sbw.model;

import java.io.Serializable;

/**
 * @author vasile.mihali
 * @since 2/24/2020
 */
public interface Identifiable<T extends Serializable> extends Serializable {

    T getId();
}

