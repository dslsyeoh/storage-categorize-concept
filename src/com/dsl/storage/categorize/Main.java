/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved.
 */

package com.dsl.storage.categorize;

import com.dsl.storage.categorize.constants.Category;
import com.dsl.storage.categorize.utils.StorageUtils;

import java.util.stream.Stream;

import static com.dsl.storage.categorize.constants.Category.*;

public class Main
{
    public static void main(String[] args)
    {
        StorageUtils.init();

        // assume user in category_1
        StorageUtils.setCategory(CATEGORY_1);
        StorageUtils.putData("category", "game");
        StorageUtils.putData("type", "racing");

        // user switch to category 2
        StorageUtils.setCategory(CATEGORY_2);
        StorageUtils.putData("category", "entertainment");
        StorageUtils.putData("type", "anime");
        StorageUtils.putData("players", "2");

        // user switch to category 1
        StorageUtils.setCategory(CATEGORY_1);
        StorageUtils.putData("players", "2");

        // user switch to category 3
        StorageUtils.setCategory(CATEGORY_3);
        StorageUtils.putData("category", "outfit");
        StorageUtils.putData("type", "casual");
        StorageUtils.putData("brand", "x");

        // display all categories
        Stream.of(CATEGORY_1, CATEGORY_2, CATEGORY_3)
                .map(Category::name)
                .forEach(category -> {
                    System.out.println("================= " + category + " ==================");
                    StorageUtils.getData(category).forEach((key, value) -> System.out.println(key + "=" + value));
                });
    }
}
