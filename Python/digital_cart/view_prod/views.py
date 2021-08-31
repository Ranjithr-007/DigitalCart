from django.shortcuts import render
from django.http import HttpResponse
from view_prod.models import Product

# Create your views here.

def prod(request):
    objlist=Product.objects.all()

    context={
        'objval': objlist,

    }
    return render(request, 'view_prod/view_product.html',context)

