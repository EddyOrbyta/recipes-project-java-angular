import { RicettaWithScore } from "./RicettaWithScore";

export interface RicettaListWithScore {

    ricettaList: RicettaWithScore[],
    totalPages: number;
    currentPage: number;
    totalElements: number;
}