import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { Component } from 'react'
import Header from './Header'
import {BrowserRouter, Route} from "react-router-dom";
import Register from "./Register";
import Sth from "./sth";
import Login from "./Login";

class App extends  Component{
    render() {
        return (
                <div className="App">
                    <BrowserRouter>
                        <Header />
                        <Route path="/index">
                            <Sth />
                        </Route>
                        <Route path="/login">
                            <Login />
                        </Route>
                        <Route path="/register">
                            <Register/>
                        </Route>
                    </BrowserRouter>
                </div>
        );
    }
}
export default App;