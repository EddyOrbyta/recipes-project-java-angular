import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-video-gallery',
  templateUrl: './video-gallery.component.html',
  styleUrls: ['./video-gallery.component.css']
})
export class VideoGalleryComponent implements OnInit {
  images: Array<any> = [];

  constructor() { }

  ngOnInit(): void {
      this.images = [
          { random: 'Orto e cucina', picture: 'https://citynews-latinatoday.stgy.ovh/~media/original-hi/11299258288192/giorgione-2-4.jpg' },
          { random: 'Giorgione', picture: 'https://www.ristorazioneitalianamagazine.it/CMS/wp-content/uploads/2024/05/Giorgione.jpg' },
          { random: 'In cucina con me', picture: 'https://www.ifood.it/wp-content/uploads/2023/06/Giorgione-in-cucina-iFood.it-foto-Facebook.jpg' },
      ];
  }
}
