package com.jzheadley.eat;

import com.jzheadley.eat.Models.*;
import com.jzheadley.eat.Respositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@ComponentScan
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    private Menu toqueLunchMenu = new Menu("Toque Lunch Menu");
    private Menu toqueDinnerMenu = new Menu("Toque Dinner Menu");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        initMenu1Data();
        initMenu2Data();

        User jzheadley = new User("jzheadley", "r0dkcDGljlhTEsem1bELOx6NZT12");
        User headleyjz = new User("headleyjz", "VyT8kfduPWfTT0uq00zMiFKyJWq2");
        Collection<Menu> menus = new ArrayList<Menu>();
        menus.add(toqueLunchMenu);
        menus.add(toqueDinnerMenu);
        Restaurant laToque = new Restaurant("La Toque", "Some Description of the restaurant", " 94559", "1314 McKinstry St.", "Napa", "Ca", "http://latoque.com/wp-content/uploads/2015/10/Night-Patio-resized-e1455670947299.jpg", 1);
        laToque.setMenus(menus);
        restaurantRepository.save(laToque);
        restaurantRepository.save(new Restaurant("Alero Mexican Restaurant", "description", "23220", "417 w grace st", "Richmond", "United States", "https://static1.squarespace.com/static/52f3de89e4b0ad0ada6fe955/t/54daf5c8e4b0f48761189fcd/1423636252957/?format=1000w", 1));
        restaurantRepository.save(new Restaurant("restaurantName", "description", "testZip", "address of the restaurant", "city name", "country of restaurant", "http://lorempixel.com/output/city-q-c-1024-1024-7.jpg", 2));
        restaurantRepository.save(new Restaurant("restaurantName", "description", "testZip", "address of the restaurant", "city name", "country of restaurant", "http://lorempixel.com/output/city-q-c-1024-1024-7.jpg", 1));
        restaurantRepository.save(new Restaurant("restaurantName", "description", "testZip", "address of the restaurant", "city name", "country of restaurant", "http://lorempixel.com/output/city-q-c-1024-1024-7.jpg", 2));
        restaurantRepository.save(new Restaurant("restaurantName", "description", "testZip", "address of the restaurant", "city name", "country of restaurant", "http://lorempixel.com/output/city-q-c-1024-1024-7.jpg", 1));
        restaurantRepository.save(new Restaurant("restaurantName", "description", "testZip", "address of the restaurant", "city name", "country of restaurant", "http://lorempixel.com/output/city-q-c-1024-1024-7.jpg", 1));
        restaurantRepository.save(new Restaurant("restaurantName", "description", "testZip", "address of the restaurant", "city name", "country of restaurant", "http://lorempixel.com/output/city-q-c-1024-1024-7.jpg", 2));
        restaurantRepository.save(new Restaurant("restaurantName", "description", "testZip", "address of the restaurant", "city name", "country of restaurant", "http://lorempixel.com/output/city-q-c-1024-1024-7.jpg", 1));
        restaurantRepository.save(new Restaurant("restaurantName", "description", "testZip", "address of the restaurant", "city name", "country of restaurant", "http://lorempixel.com/output/city-q-c-1024-1024-7.jpg", 2));

        userRepository.save(jzheadley);
        userRepository.save(headleyjz);

        for (MenuItem menuItem : menuItemRepository.findAll()) {
            logger.info(menuItem.toString());
        }
        for (Category category : categoryRepository.findAll()) {
            logger.info(category.toString());
        }


        logger.info("\n\n\n");
//        logger.info(userRepository.findByFirebaseId("VyT8kfduPWfTT0uq00zMiFKyJWq2").toString());
    }

    private void initMenu2Data() {
        Category firstCourses = new Category("First Courses");
        Collection<MenuItem> firstCoursesCollection = new ArrayList<MenuItem>();
        Category mainCourses = new Category("Main Courses");
        Collection<MenuItem> mainCoursesCollection = new ArrayList<MenuItem>();
        Category cheeses = new Category("Cheeses");
        Collection<MenuItem> cheesesCollection = new ArrayList<MenuItem>();
        Category desserts = new Category("Desserts");
        Collection<MenuItem> dessertsCollection = new ArrayList<MenuItem>();
        firstCoursesCollection.add(new MenuItem("OAK LEAF SALAD", "yellow beans, parsley, radish, croutons, marinated chanterelle mushrooms, Cabernet Sauvignon vinaigrette"));
        firstCoursesCollection.add(new MenuItem("VENISON TERRINE", "crab apple water gel, green onions, shiitake mushrooms, marinated zucchini"));
        firstCoursesCollection.add(new MenuItem("PAN SEARED MUSHROOMS", "bread tuile, black garlic purée, pancetta, Madeira sauce"));
        firstCoursesCollection.add(new MenuItem("TUNA TARTARE", "tomato water mousse, green beans, marinated cucumber, lime vinaigrette, garlic mayonnaise"));
        firstCoursesCollection.add(new MenuItem("GUINEA FOWL LIVER MOUSSE", "pickle, strawberries, arugula, radish, toast, Minus 8 vinaigrette"));
        mainCoursesCollection.add(new MenuItem("CAVATELLI", "$28", "chives, shiitake mushrooms, parmigiano reggiano"));
        mainCoursesCollection.add(new MenuItem("FLUKE FISH", "$32", "coco bean cassolette, carrots, tomato, bacon, fish fumet"));
        mainCoursesCollection.add(new MenuItem("BEEF STRIPLOIN", "$38", "artichoke barigoule, roasted potatoes, beans, porcini mushrooms, bordelaise sauce"));
        mainCoursesCollection.add(new MenuItem("BRAISED VEAL SHOULDER", "$34", "spelt, Kalamata olives, zucchini, roasted bell pepper, shiitake mushrooms"));
        mainCoursesCollection.add(new MenuItem("LINE CAUGHT BLUEFIN TUNA LOIN", "$52", "carrots, beet, marinated lobster mushrooms, sauce vierge"));
        mainCoursesCollection.add(new MenuItem("DUCK MAGRET", "$42", "sea orach purée, braised fennel, flat beans, corn, amanita mushrooms, poivrade sauce"));
        cheesesCollection.add(new MenuItem("LA TOMME À RUDY AND LA CHARRUE", "$12", "smoked tea apple compotée, camelina cracker, pickled radish"));
        dessertsCollection.add(new MenuItem("EARL GREY TEA MOUSSE", "$10", "raspberry jam, yogurt, brioche tuile and ice cream"));
        dessertsCollection.add(new MenuItem("CHOCOLATE GELÉE AND TORTE", "$10", "sea buckthorn berries, pine nut nougatine, hay caramel and ice cream"));
        dessertsCollection.add(new MenuItem("APPLE BOULANGÈRE", "$10", "thyme mousse, miso caramel, oat crumble and ice cream"));
        dessertsCollection.add(new MenuItem("STRAWBERRY AND RED WINE SAVARIN", "$10", "sweet clover ganache, strawberry chips and sorbet"));
        desserts.setMenuItems(dessertsCollection);
        mainCourses.setMenuItems(mainCoursesCollection);
        firstCourses.setMenuItems(firstCoursesCollection);
        cheeses.setMenuItems(cheesesCollection);
        Collection<Category> categories = new ArrayList<Category>();
        categories.add(cheeses);
        categories.add(desserts);
        categories.add(firstCourses);
        categories.add(mainCourses);
        toqueLunchMenu.setCategories(categories);
        menuRepository.save(toqueLunchMenu);
    }

    private void initMenu1Data() {
        // First Courses of TestMenu
        MenuItem menuItem1 = new MenuItem("Pan Seared Foie Gras", "$30", "peach, shiitakes, tarragon, puffed buckwheat, buckwheat crumble");
        MenuItem menuItem2 = new MenuItem("Marinated Princess Scallops", "$24", "kohlrabi, pear water, coriander mousse");
        MenuItem menuItem3 = new MenuItem("Venison Carpaccio", "$28", "cherry tomatoes, sorrel emulsion, marinated lobster mushrooms and cucumber");
        MenuItem menuItem4 = new MenuItem("Flounder Sashimi", "$25", "soy gel, green onion, yuzu, radish, shiso, spicy mayonnaise");
        MenuItem menuItem5 = new MenuItem("Stone Crab", "$24", "heirloom tomato, pancetta, fennel, croutons, sweet cicely, arugula, verjuice vinaigrette");
        MenuItem menuItem6 = new MenuItem("Razor Clams", "$25", "hedgehog mushrooms, fresh almonds, sea orach, artichoke, garlic and chorizo broth");
        Category firstCourses = new Category("First Courses");
        Collection<MenuItem> firstCoursesCollection = new ArrayList<MenuItem>();
        firstCoursesCollection.add(menuItem1);
        firstCoursesCollection.add(menuItem2);
        firstCoursesCollection.add(menuItem3);
        firstCoursesCollection.add(menuItem4);
        firstCoursesCollection.add(menuItem5);
        firstCoursesCollection.add(menuItem6);
        firstCourses.setMenuItems(firstCoursesCollection);
        // Main courses of TestMenu
        MenuItem menuItem7 = new MenuItem("DUCK MAGRET", "$52", "chanterelle mushrooms, carrots, turnip, coco bean purée, Madeira sauce");
        MenuItem menuItem8 = new MenuItem("LINE CAUGHT BLUEFIN TUNA LOIN", "$55", "eggplant purée, onion, herring roes, zucchini, kombu meat jus");
        MenuItem menuItem9 = new MenuItem("GUINEA FOWL BREAST", "$46", "artichoke, chanterelle mushrooms, leek, corn, sweet cicely, fresh almonds, poivrade sauce");
        MenuItem menuItem10 = new MenuItem("VENISON LOIN", "$55", "sea parsley purée, green beans, radish, bolete mushrooms, black garlic purée, bordelaise sauce");
        MenuItem menuItem11 = new MenuItem("RACK OF SUCKLING PIG", "$50", "bell pepper purée, blue-staining boletes, fennel, tomato, cherry bomb pepper, lemon thyme sauce");
        MenuItem menuItem12 = new MenuItem("CAVATELLI WITH STONE CRAB", "$52", "wild mushrooms, Swiss chard, Parmigiano Reggiano");
        Category mainCourses = new Category("Main Courses");
        Collection<MenuItem> mainCoursesCollection = new ArrayList<MenuItem>();
        mainCoursesCollection.add(menuItem7);
        mainCoursesCollection.add(menuItem8);
        mainCoursesCollection.add(menuItem9);
        mainCoursesCollection.add(menuItem10);
        mainCoursesCollection.add(menuItem11);
        mainCoursesCollection.add(menuItem12);
        mainCourses.setMenuItems(mainCoursesCollection);
        // Cheeses of TestMenu
        MenuItem menuItem13 = new MenuItem("LA TOMME À RUDY AND LE CHARRUE", "$16", "smoked tea apple compote, camelina seed crackers, pickled radishes");
        Category cheeses = new Category("Cheeses");
        Collection<MenuItem> cheesesCollection = new ArrayList<MenuItem>();
        cheesesCollection.add(menuItem13);
        cheeses.setMenuItems(cheesesCollection);
        // Desserts of TestMenu
        MenuItem menuItem14 = new MenuItem("ANDOA MILK CHOCOLATE AND LIME MOUSSE", "$18", "chocolate puff pastry, Andoa dark chocolate and juniper sauce, blueberry sorbet");
        MenuItem menuItem15 = new MenuItem("ROOÏBOS TEA AND WHITE CHOCOLATE GELÉE", "$17", "praline cream, milk genoise, roasted peach sorbet");
        MenuItem menuItem16 = new MenuItem("LA BEURRASSE GOAT CHEESE BAVARIAN CREAM", "$17", "Manjari chocolate ganache, almond and cocoa crumble, candied beets, beet and milk sorbet");
        MenuItem menuItem17 = new MenuItem("CARAMELISED WHITE CHOCOLATE TORTE", "$18", "yogurt curd, star anise cream, sea buckthorn gel and berries, sea buckthorn frozen yogurt");
        MenuItem menuItem18 = new MenuItem("MATCHA TEA MERINGUE", "$18", "black sesame sponge cake, toasted rice crème anglaise, tarragon and almond powder, miso cream, morello cherry granité");
        MenuItem menuItem19 = new MenuItem("ICED COFFEE", "$18", "Chic-Choc spiced rum, cream, honey syrup, sweet clover extract\n");
        MenuItem menuItem20 = new MenuItem("TASTING OF TWO OOLONG TEAS", "$14", "");
        Category desserts = new Category("Desserts");
        Collection<MenuItem> dessertsCollection = new ArrayList<MenuItem>();
        dessertsCollection.add(menuItem14);
        dessertsCollection.add(menuItem15);
        dessertsCollection.add(menuItem16);
        dessertsCollection.add(menuItem17);
        dessertsCollection.add(menuItem18);
        dessertsCollection.add(menuItem19);
        dessertsCollection.add(menuItem20);
        desserts.setMenuItems(dessertsCollection);
        Collection<Category> menuCategories = new ArrayList<Category>();
        menuCategories.add(firstCourses);
        menuCategories.add(mainCourses);
        menuCategories.add(cheeses);
        menuCategories.add(desserts);
        toqueDinnerMenu.setCategories(menuCategories);
        menuRepository.save(toqueDinnerMenu);
    }
}
