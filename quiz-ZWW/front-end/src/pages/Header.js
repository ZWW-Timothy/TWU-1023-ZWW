import React from "react"
import {NavLink} from 'react-router-dom';
import './Header.css';

const Header = () => {
    return (
        <nav className="nav" style={{ paddingLeft: "30px" }}>
            <NavLink to="/" className="nav-link" exact activeStyle={{ backgroundColor: "rgb(55, 135, 210)" }}>
                △ 商城
            </NavLink>
            <NavLink to="/buyList" className="nav-link" exact activeStyle={{ backgroundColor: "rgb(55, 135, 210)" }}>
                □ 订单
            </NavLink>
            {/* <NavLink to="/addItem" className="nav-link" exact activeStyle={{ textDecoration: "underline", color: "rgb(195,205,50)" }}> */}
            <NavLink to="/addItem" className="nav-link" exact activeStyle={{ backgroundColor: "rgb(55, 135, 210)" }}>
                + 添加商品
            </NavLink>
        </nav>
    )
};

export default Header;
