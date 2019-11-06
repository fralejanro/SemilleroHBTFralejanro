/**
 * @description Clase que representa un Libro
 * 
 * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
 */
export class Libro {
    /**
     * Atributo que representa el id de un libro
     */
    public id: number;
    /**
     * Atributo que representa el nombre de un libro
     */
    public nombre: string;
    /**
     * Atributo que representa la editorial de un libro
     */
    public editorial: string;
    /**
     * Atributo que representa el número de páginas de un libro
     */
    public numeroPaginas: number;
    /**
     * Atributo que representa el precio de un libro
     */
    public precio: number;
    /**
     * Atributo que representa el autor o autores de un libro
     */
    public autores: string;
    /**
     * Atributo que representa si un libro es a color o no 
     */
    public acolor: boolean;
    /**
     * Atributo que representa la fecha de venta de un libro
     */
    public fechaVenta: Date;
    /**
     * Atributo que representa si un libro esta disponible para la venta o no
     */
    public estado: string;

    /**
     * Constructor de la clase
     * @param id 
     * @param nombre 
     * @param editorial 
     * @param numeroPaginas 
     * @param precio 
     * @param autores 
     * @param acolor 
     * @param fechaVenta 
     * @param estado 
     */
    constructor(
        id: number, 
        nombre: string, 
        editorial: string, 
        numeroPaginas: number, 
        precio: number, 
        autores: string, 
        acolor: boolean, 
        fechaVenta: Date, 
        estado: string
        ) {
            this.id = id;
            this.nombre = nombre;
            this.editorial = editorial;
            this.numeroPaginas = numeroPaginas;
            this.precio = precio;
            this.autores = autores;
            this.acolor = acolor;
            this.fechaVenta = fechaVenta;
            this.estado = estado;
        }
}