package org.csystem.samples;

import org.csystem.util.Pair;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static org.csystem.util.Pair.create;

public final class ProductFactory {
    private List<Product> m_products = new ArrayList<>();
    private Random m_random = new Random();

    private static Product getProductFromLine(String line)
    {
        var productsInfo = line.split("[,]");

        int length = productsInfo.length;
        var id = Integer.parseInt(productsInfo[0]);
        var stock = Double.parseDouble(productsInfo[length - 3]);
        var cost = new BigDecimal(productsInfo[length - 2]);
        var price = new BigDecimal(productsInfo[length - 1]);

        var stringBuilder = new StringBuilder();

        for (int i = 1; i < length - 3; ++i)
            stringBuilder.append(productsInfo[i]).append(',');

        var name = stringBuilder.substring(0, stringBuilder.length() - 1);

        return new Product(id, name, stock, cost, price);
    }

    private ProductFactory()
    {}

    public void setRandom(Random random)
    {
        m_random = random;
    }

    public static ProductFactory loadFromFile(String path) throws IOException
    {
        var productFactory = new ProductFactory();

        productFactory.m_products = Files.lines(Path.of(path))
                .skip(1)
                .map(ProductFactory::getProductFromLine)
                .collect(Collectors.toList());

        return productFactory;
    }

    public List<Product> getProducts()
    {
        return m_products;
    }


    public List<Pair<Integer, Product>> getProductPairs()
    {
        return m_products.stream().map(p -> create(p.getId(), p)).collect(Collectors.toList());
    }

    public Optional<Product> getRandomProduct()
    {
        var size = m_products.size();

        return size != 0 ? Optional.of(m_products.get(m_random.nextInt(size))) : Optional.empty();
    }

    public Iterable<Product> getProductsAsIterable()
    {
        return getProducts();
    }

    //...
}
