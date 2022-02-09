package com.obsqura.testngbasis;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableUtility {
    public static List<ArrayList<String>> get_Dynamic_TwoDimension_TableElements(List<WebElement> rowItems, List<WebElement> columnItems) {
        int rSize = rowItems.size() - 1;
        int columnSize = columnItems.size();

        //List<WebElement> rowItems = driver.findElements(By.xpath("//div[@class='su-table su-table-alternate']//tr"));
        //List<WebElement> coloumnItems = driver.findElements(By.xpath("//div[@class='su-table su-table-alternate']//tr//td"));
        String[] columnList = new String[columnSize / rSize];

        List<ArrayList<String>> gridData = new ArrayList<ArrayList<String>>();
        int x = 0;
        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < columnList.length; j++) {
                columnList[j] = columnItems.get(x).getText();
                x++;
                // gridData.addAll(columnList[j]);
            }
            //x++;
            gridData.add(new ArrayList<String>(Arrays.asList(columnList)));

        }
        return gridData;
    }
}
