import React, { Component } from 'react';
import itemImg from '../images/Item-Cola.jpg';

export class HomeProduct extends Component {
    render() {
      return (
        <div className="homeProducts">
          <img src={itemImg} alt={this.props.string.name} />
          <span className="itemName">{this.props.string.name}</span>
          <span>单价：</span><span className="itemPrice">{this.props.string.price}</span><span>元/</span><span className="itemPrice">{this.props.string.unit}</span>
          <button className="addItemButton" onClick={this.props.int.buyNum}></button>
        </div>
     );
   } 
}  

export default HomeProduct;
