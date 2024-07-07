import { Ricetta } from "./Ricetta";

export interface RicettaList {

    ricettaList: Ricetta[];
    totalPages: number;
    currentPage: number;
    totalElements: number;
}