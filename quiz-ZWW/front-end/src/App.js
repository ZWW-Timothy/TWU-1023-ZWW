// import React from 'react';
// import logo from './logo.svg';
import './App.css';

import React, { Component } from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import Header from './pages/Header';
import Home from './pages/Home';
import BuyList from './pages/BuyList';
import AddItem from './pages/AddItem';


class App extends Component {
  render() {
    return (
      <div className="app">
        <Router>
          <Header />
          <Switch>
            <Route exact path='/buyList' component={BuyList} />
            <Route exact path='/addItem' component={AddItem} />
            <Route exact path='/' component={Home} />
          </Switch>
        </Router>
        <footer>
            TW Mall @2018 Created by ForCheng
        </footer>
      </div>
    );
  }
}

/*
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}
*/

export default App;
