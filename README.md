# PlantUML Converter

PlantUML Converter is a service to convert YAML data into SVG diagrams using the PlantUML library. With this tool data can be visualized and styled. 

# Endpoints

## Post
```
http://localhost:8080/api/yaml/text
```

### Example YAML request
```
doe: "a deer, a female deer"
ray: "a drop of golden sun"
pi: 3.14159
xmas: true
french-hens: 3
calling-birds: 
	- huey
	- dewey
	- louie
	- fred
xmas-fifth-day: 
	calling-birds: four
	french-hens: 3
	golden-rings: 5
	partridges: 
		count: 1
		location: "a pear tree"
	turtle-doves: two
```

### Response
![readme-yaml-image](https://user-images.githubusercontent.com/89127725/224015525-2cf3dded-9cf1-4c63-8ac0-9a830fb05e10.png)


---
## Created by Felix Jacobsen
