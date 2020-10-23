import React, { Component } from 'react';
import itemImg from '../images/Item-Cola.jpg';

export class HomeProduct extends Component {
    render() {
      return (
        <div className="homeProducts">
          <img src={itemImg} alt="可乐" />
        </div>
     );
   } 
}  

export default HomeProduct;
