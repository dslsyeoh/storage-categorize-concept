package com.dsl.storage.categorize.utils;

import com.dsl.storage.categorize.constants.Category;

import java.util.*;

import static com.dsl.storage.categorize.constants.Category.*;

public class StorageUtils
{
    private StorageUtils() {}

    private static Map<String, Map<String, String>> categories;
    private static Category category;

    public static void init()
    {
        categories = new HashMap<>();
        categories.put(CATEGORY_1.name(), new HashMap<>());
        categories.put(CATEGORY_2.name(), new HashMap<>());
        categories.put(CATEGORY_3.name(), new HashMap<>());
    }

    public static Map<String, String> getData(String key)
    {
        return categories.get(key);
    }

    public static void putData(String key, String value)
    {
        categories.get(category.name()).put(key, value);
    }

    public static void setCategory(Category category)
    {
        StorageUtils.category = category;
    }
}
