from fastapi import FastAPI, Query
from typing import List, Optional

app = FastAPI()

# Base de datos simulada
books = [
    {"id": 1, "title": "El Principito", "author": "Antoine de Saint-Exupéry", "genre": "Ficción"},
    {"id": 2, "title": "1984", "author": "George Orwell", "genre": "Distopía"},
    {"id": 3, "title": "Cien Años de Soledad", "author": "Gabriel García Márquez", "genre": "Realismo Mágico"},
    {"id": 4, "title": "Orgullo y Prejuicio", "author": "Jane Austen", "genre": "Romance"},
    {"id": 5, "title": "Don Quijote", "author": "Miguel de Cervantes", "genre": "Clásico"},
]

# Ruta raíz
@app.get("/")
def read_root():
    return {"message": "Bienvenido a la API de búsqueda de libros"}

# Endpoint para buscar libros
@app.get("/books", response_model=List[dict])
def search_books(
    title: Optional[str] = Query(None, description="Título del libro a buscar"),
    author: Optional[str] = Query(None, description="Autor del libro a buscar"),
    genre: Optional[str] = Query(None, description="Género del libro a buscar"),
):
    results = books

    # Filtrar por título
    if title:
        results = [book for book in results if title.lower() in book["title"].lower()]
    
    # Filtrar por autor
    if author:
        results = [book for book in results if author.lower() in book["author"].lower()]
    
    # Filtrar por género
    if genre:
        results = [book for book in results if genre.lower() in book["genre"].lower()]

    return results
