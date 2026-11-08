# Product Store - RecyclerView (Java + XML)

This Android Studio project recreates the product-grid screen from the assignment reference.

## Requirements
- Android Studio
- Android SDK Platform 35
- JDK 11 or the JDK bundled with Android Studio

## Open the project
1. Extract the ZIP file.
2. In Android Studio choose **Open**.
3. Select the `ProductStoreRecyclerView` folder.
4. Allow Gradle Sync to finish.
5. Run the app on an emulator or Android device.

## RecyclerView concepts used
- `Product.java`: data model for one product.
- `item_product.xml`: XML layout for one product card.
- `ProductAdapter.java`: RecyclerView Adapter and ViewHolder.
- `activity_main.xml`: screen layout containing RecyclerView.
- `MainActivity.java`: creates product data and connects the RecyclerView.

The reference design displays two products per row, so the app uses:
`recyclerView.setLayoutManager(new GridLayoutManager(this, 2));`

The sample uses a local vector drawable as a placeholder product image. Replace
`camera_product.xml` with product photos if you have the original images.


## Gradle configuration (stable compatible versions)

This project uses Android Gradle Plugin 8.6.1 with Gradle 8.7 and JDK 17.
The wrapper configuration is located at:
`gradle/wrapper/gradle-wrapper.properties`

### Important: offline use

The `distributionUrl` above points to the official Gradle 8.7 distribution.
On a computer where Gradle 8.7 has never been downloaded, the first sync
requires the distribution to be available locally or an internet connection.
A properties file cannot provide the Gradle distribution itself.

For fully offline use:
1. Make sure Gradle 8.7 is already installed or its ZIP is available on the computer.
2. Change `distributionUrl` to a local file URL that matches the actual ZIP location,
   for example on Windows:
   `distributionUrl=file\:///C:/Gradle/gradle-8.7-bin.zip`
3. In Android Studio, use JDK 17: Settings > Build, Execution, Deployment >
   Build Tools > Gradle > Gradle JDK.
4. Enable Gradle Offline mode only if the required Android Gradle Plugin and
   dependencies are already cached.

### Wrapper scripts

This archive includes `gradle-wrapper.properties`, but does not include the
Gradle Wrapper JAR or generated `gradlew` / `gradlew.bat` scripts. Those files
must be generated using an installed Gradle 8.7 distribution (`gradle wrapper
--gradle-version 8.7`) or created by Android Studio. Do not create an empty
wrapper JAR; it will not work.
