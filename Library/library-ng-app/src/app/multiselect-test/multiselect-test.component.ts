import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-multiselect-test',
  templateUrl: './multiselect-test.component.html',
  styleUrls: ['./multiselect-test.component.css']
})
export class MultiselectTestComponent implements OnInit {
  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};

  ngOnInit(): void {
    this.dropdownList = [
      {item_id: '1', item_name: 'One'},
      {item_id: '2', item_name: 'Two'},
      {item_id: '3', item_name: 'Three'},
      {item_id: '4', item_name: 'Four'},
      {item_id: '5', item_name: 'Five'}
    ];
    this.selectedItems = [
      {item_id: '1', item_name: 'One'},
      {item_id: '2', item_name: 'Two'}
    ];
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_name',
      selectAllText: 'Select All',
      unSelectAllText: 'unSelect All',
      itemsShowLimit: 5,
      allowSearchFilter: false
    };
  }

  onItemSelect(item: any) {
    console.log(item);
  }

  onSelectAll(items: any) {
    console.log(items);
  }
}
