# HexOhm Output

Generates a table of power output from the [Hexohm 3.0](https://cravingvapor.com/product-category/hardware/hexohm-box-mods/) based on coil resistance.

## Usage

Build the project and run on the command line or simply run the `HexohmOutputApplication` in your IDE.

```bash
$ ./gradlew clean build
$ java -jar build/libs/hexohm-output-0.0.1-SNAPSHOT.jar

. . .

shell:>wattage-table --resistance 0.23
+-------------+-------+
|Potentiometer|Wattage|
+-------------+-------+
|            0|   46.0|
+-------------+-------+
|           10|   50.0|
+-------------+-------+
|           20|   54.0|
+-------------+-------+
|           30|   60.0|
+-------------+-------+
|           40|   66.0|
+-------------+-------+
|           50|   75.0|
+-------------+-------+
|           60|   85.0|
+-------------+-------+
|           70|  100.0|
+-------------+-------+
|           80|  115.0|
+-------------+-------+
|           90|  133.0|
+-------------+-------+
|          100|  157.0|
+-------------+-------+

```
