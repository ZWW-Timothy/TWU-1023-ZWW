import React, {Component} from 'react';
import './AddItem.css';
import 'bootstrap/dist/css/bootstrap.css'
// import { notification } from 'antd/lib';

class AddItem extends Component {
  state = {
    name: "",
    price: "",
    unit: "",
    img: "",
  }

  handleAddItem = () => {

  }

  checkPrice = (price) => {
    const priceRegexNotNeg = /^\d+(\.\d+)?$/;
    if (priceRegexNotNeg.test(price)){
      if (parseFloat(price) > 0) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  handleFieldChange = (field, event) => {
    this.setState({
      [field]: event.target.value,
    });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    fetch('http://localhost:3080/addItem', {
      method: "POST",
　　  headers: {
　　　　'Content-Type': 'application/json'
　　  },
　　  body: JSON.stringify(this.state)
    })
    .then(response => {
      if (response === 200) {
      } else {
        // notification.error({
        //   message: '添加商品失败',
        //   description: '商品名称已存在，请输入新的商品名称',
        // });
      }
    })
  }

  render() {
    return (
      <div className="container">
        <h1>添加商品</h1>
        <form className="addItem" onSubmit={(e) => this.handleSubmit(e)}>

          <div className="form-group">
          <span className="signal">* </span><span htmlFor="name">名称：</span>
            <input
              type="text"
              value={this.state.name}
              onChange={(e) => this.handleFieldChange("name", e)}
              className="form-control"
              id="name"
              placeholder="名称"
            />
          </div>

          <div className="form-group">
          <span className="signal">* </span><span htmlFor="price">价格：</span>
            <input
              type="text"
              value={this.state.price}
              onChange={(e) => this.handleFieldChange("price", e)}
              className="form-control"
              id="price"
              placeholder="价格"
            />
          </div>

          <div className="form-group">
          <span className="signal">* </span><span htmlFor="unit">单位：</span>
            <input
              type="text"
              value={this.state.unit}
              onChange={(e) => this.handleFieldChange("unit", e)}
              className="form-control"
              id="unit"
              placeholder="单位"
            />
          </div>

          <div className="form-group">
          <span className="signal">*</span> <span htmlFor="img">图片：</span>
            <input
              type="text"
              value={this.state.img}
              onChange={(e) => this.handleFieldChange("img", e)}
              className="form-control"
              id="img"
              placeholder="URL"
            />
          </div>

          <input
            disabled={!this.state.name || !this.state.price || !this.state.unit || !this.state.img || !this.checkPrice(this.state.price)}
            type="submit"
            value="提交"
            className="btn btn-primary btn-lg"
          />

        </form>
      </div>
    );
  }
}

export default AddItem;
