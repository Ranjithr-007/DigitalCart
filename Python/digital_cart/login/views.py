from django.shortcuts import render
from django.http import HttpResponse
from login.models import Login
# Create your views here.

def log(request):

        # return HttpResponse("hello world")
        if request.method == "POST":

            un = request.POST.get('un')

            pwd = request.POST.get('pass')
            objs = Login.objects.filter(user_name=un, password=pwd)

            tp = ""
            for o in objs:
                tp = o.type
            if tp == 'admin':
                return render(request, 'staff_reg/staff_reg.html')
            else:

                return render(request, 'login/login.html')
                return HttpResponse("incurrect password")

        return render(request, 'login/login.html')

