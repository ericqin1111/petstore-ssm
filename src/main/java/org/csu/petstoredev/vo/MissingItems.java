package org.csu.petstoredev.vo;

import lombok.Data;
import org.csu.petstoredev.entity.Item;

import java.util.List;

@Data
public class MissingItems {
    List<String> itemNames;
    boolean has;
}
