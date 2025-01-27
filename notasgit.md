NOTAS GIT 
Configurar Nombre que salen en los commits
	git config --global user.name "dasdo"
Configurar Email
	git config --global user.email dasdo1@gmail.com
Iniciando repositorio

Iniciamos GIT en la carpeta donde esta el proyecto
	git init
Clonamos el repositorio de github o bitbucket
	git clone <url>
Añadimos todos los archivos para el commit
	git add .
Hacemos el primer commit
	git commit -m "Texto que identifique por que se hizo el commit"
subimos al repositorio
	git push origin master
GIT CLONE

Clonamos el repositorio de github o bitbucket
	git clone <url>
Clonamos el repositorio de github o bitbucket ?????
	git clone <url> git-demo
GIT ADD

Añadimos todos los archivos para el commit
	git add .
Añadimos el archivo para el commit
	git add <archivo>
Añadimos todos los archivos para el commit omitiendo los nuevos
	git add --all 
Añadimos todos los archivos con la extensión especificada
	git add *.txt
Añadimos todos los archivos dentro de un directorio y de una extensión especifica
	git add docs/*.txt
Añadimos todos los archivos dentro de un directorios
	git add docs/
GIT COMMIT

Cargar en el HEAD los cambios realizados
	git commit -m "Texto que identifique por que se hizo el commit"
Agregar y Cargar en el HEAD los cambios realizados
	git commit -a -m "Texto que identifique por que se hizo el commit"
De haber conflictos los muestra
	git commit -a 
Agregar al ultimo commit, este no se muestra como un nuevo commit en los logs. Se puede especificar un nuevo mensaje
	git commit --amend -m "Texto que identifique por que se hizo el commit"
GIT PUSH

Subimos al repositorio
	git push <origien> <branch>
Subimos un tag
	git push --tags 
GIT LOG
Muestra los logs de los commits
	git log
Muestras los cambios en los commits
	git log --oneline --stat
Muestra graficos de los commits
	git log --oneline --graph


OTROS COMANDOS

Lista un estado actual del repositorio con lista de archivos modificados o agregados
	git status
Quita del HEAD un archivo y le pone el estado de no trabajado
	git checkout -- <file>
Crea un branch en base a uno online
	git checkout -b newlocalbranchname origin/branch-name
Busca los cambios nuevos y actualiza el repositorio
	git pull origin <nameBranch>
Cambiar de branch
	git checkout <nameBranch/tagname>
Une el branch actual con el especificado
	git merge <nameBranch>
Verifica cambios en el repositorio online con el local
	git fetch
Borrar un archivo del repositorio
	git rm <archivo> 
Para ver las rama en la que estas:
git branch CAMBIO DE RAMA  git checkout <rama> RECUPERAR INFORMACION DE LA RAMA EN LA QUE ESTAS  git pull origin <rama>   5. Ramas
* git branch: Muestra las ramas existentes y resalta la rama actual.
* git branch <nombre>: Crea una nueva rama con el nombre especificado.
* git checkout <nombre>: Cambia a la rama especificada.
* git checkout -b <nombre>: Crea y cambia a una nueva rama en un solo paso.
* git merge <rama>: Fusiona la rama especificada con la rama actual.
* git branch -d <nombre>: Elimina la rama especificada (si está fusionada).
* git branch -D <nombre>: Fuerza la eliminación de la rama especificada, incluso si no está fusionada.
6. Borrar un Commit
* git reset --soft <commit>: Revierte a un commit específico sin cambiar el directorio de trabajo ni el índice.
* git reset --hard <commit>: Revierte a un commit específico, eliminando todos los cambios posteriores.git log --oneline --stat
git log --oneline --graph