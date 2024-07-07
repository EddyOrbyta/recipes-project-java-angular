export interface Ricetta {
    id: number,
    categoria: string;
    createdAt: string;
    descrizione: string;
    difficolta: string;
    foto: string;
    nome: string;
    preparazione: string;
    tempoPreparazione: string;
    tipo: string;
    updatedAt: string;
    video: string;
    numPersone: number;
    userUid: string;
    visualizzazioni: number; 
}